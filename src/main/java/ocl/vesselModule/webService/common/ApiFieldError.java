package ocl.vesselModule.webService.common;

public class ApiFieldError {
    public String field;
    public String code;
    public Object rejectedValue;

    public ApiFieldError(String field, String code, Object rejectedValue) {
        this.field = field;
        this.code = code;
        this.rejectedValue = rejectedValue;
    }
}
