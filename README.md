# EPAM--PEP-HOMETASKS

public class AuthenticationFilter implements Filter {
    private RequestMappingHandlerMapping handlerMapping;
    private List<String> allowedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = SpringApplication.getContext();
        handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        allowedUrls = ContextTeller.getProperty();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        String requestMethod = httpRequest.getMethod();

        for (String allowedUrl : allowedUrls) {
            if (isUrlAndMethodAllowed(allowedUrl, requestURI, requestMethod)) {
                // Apply your authentication logic for the allowed URL and method
                // ...
                break;
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isUrlAndMethodAllowed(String allowedUrl, String requestURI, String requestMethod) {
        HandlerExecutionChain executionChain;
        try {
            executionChain = handlerMapping.getHandler(new HttpServletRequestWrapper((HttpServletRequest) null));
        } catch (Exception e) {
            return false;
        }

        for (HandlerInterceptor interceptor : executionChain.getInterceptors()) {
            if (interceptor instanceof RequestMappingHandlerAdapter) {
                RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) interceptor;
                HandlerMethod handlerMethod = adapter.getHandlerMethods().getHandlerMethod(requestURI, requestMethod);
                if (handlerMethod != null && isUrlMatched(allowedUrl, handlerMethod)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isUrlMatched(String allowedUrl, HandlerMethod handlerMethod) {
        Set<String> patterns = handlerMethod.getMethodAnnotation(RequestMapping.class).value();
        for (String pattern : patterns) {
            if (getPathMatcher().match(pattern, allowedUrl)) {
                return true;
            }
        }
        return false;
    }

    private PathMatcher getPathMatcher() {
        ApplicationContext context = SpringApplication.getContext();
        return context.getBean(PathMatcher.class);
    }

    @Override


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.HandlerMethod;
import org.springframework.web.servlet.config.annotation.PathMatcherConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Component
public class AuthenticationFilter implements Filter {
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
    
    @Autowired
    private ContextTeller contextTeller;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        String requestMethod = httpRequest.getMethod();

        List<String> allowedUrls = contextTeller.getProperty();

        for (String allowedUrl : allowedUrls) {
            if (isUrlAndMethodAllowed(allowedUrl, requestURI, requestMethod)) {
                // Apply your authentication logic for the allowed URL and method
                // ...
                break;
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isUrlAndMethodAllowed(String allowedUrl, String requestURI, String requestMethod) {
        RequestMappingInfo info = handlerMapping.getMappingForMethod(requestURI, requestMethod);
        if (info != null && isUrlMatched(allowedUrl, info.getPatternsCondition())) {
            return true;
        }
        return false;
    }

    private boolean isUrlMatched(String allowedUrl, PatternsRequestCondition patterns) {
        Set<String> urlPatterns = patterns.getPatterns();
        for (String pattern : urlPatterns) {
            if (getPathMatcher().match(pattern, allowedUrl)) {
                return true;
            }
        }
        return false;
    }

    private PathMatcher getPathMatcher() {
        return handlerMapping.getPathMatcher();
    }

    @Override
    public void destroy() {
    }
}
