package scr.br.com.Axwel.factory;

public class Customer {
    private String gradeRequest;
    private boolean hasCompanyContract;

    public Customer(String gradeRequest,boolean hasCompanyContract){
        this.gradeRequest = gradeRequest;
        this.hasCompanyContract = hasCompanyContract;
    }

    public boolean isHasCompanyContract() {
        return hasCompanyContract;
    }

    public String getGradeRequest() {
        return gradeRequest;
    }
}
