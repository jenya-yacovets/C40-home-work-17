package by.tms.project.exceptions;

public class ParametersNotPassedException extends Exception{
    private String nameParam;

    public ParametersNotPassedException(String nameParam) {
        this.nameParam = nameParam;
    }

    public ParametersNotPassedException() {
    }

    @Override
    public String getMessage() {
        if (nameParam == null) {
            return "Parameters not passed";
        } else {
           return String.format("The '%s' parameter was not passed", nameParam);
        }
    }
}
