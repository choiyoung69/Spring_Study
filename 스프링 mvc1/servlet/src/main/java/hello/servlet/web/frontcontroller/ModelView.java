package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {
    //Spring MVC에 실제로 model + view가 존재함
    private String viewName; //view의 논리적인 이름
    private Map<String, Object> model = new HashMap<>();

    public ModelView(final String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(final String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(final Map<String, Object> model) {
        this.model = model;
    }
}
