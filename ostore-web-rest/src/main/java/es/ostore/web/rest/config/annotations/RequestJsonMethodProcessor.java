package es.ostore.web.rest.config.annotations;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.google.gson.GsonBuilder;

public class RequestJsonMethodProcessor implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestJson.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        JSONObject json = (JSONObject) request.getSession().getAttribute("TEMP_JSON_BODY");
        if (json == null) {
            json = getJsonFromBody(request);
            request.getSession().setAttribute("TEMP_JSON_BODY", json); 
        }
        mavContainer.setRequestHandled(true);
        
        parameter = parameter.nestedIfOptional();
        java.lang.reflect.Type targetType = parameter.getNestedGenericParameterType();
        Class<?> targetClass = (targetType instanceof Class ? (Class<?>) targetType : null);
        RequestJson aa = parameter.getParameterAnnotation(RequestJson.class);
        JSONObject a = json.getJSONObject(aa.value());
        return new GsonBuilder()
        		.setDateFormat("dd/MM/yyyy HH:mm:ss").create().fromJson(a.toString(), targetClass);
        
    }
    
    private JSONObject getJsonFromBody(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject(sb.toString());
    }
    
}