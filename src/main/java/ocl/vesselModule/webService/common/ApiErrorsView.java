package ocl.vesselModule.webService.common;

import java.util.List;

public class ApiErrorsView {
    public List<ApiFieldError> fieldErrors;
    public List<ApiGlobalError> globalErrors;

    public ApiErrorsView(List<ApiFieldError> apiFieldErrors, List<ApiGlobalError> apiGlobalErrors) {
        this.fieldErrors = apiFieldErrors;
        this.globalErrors = apiGlobalErrors;
    }


}
