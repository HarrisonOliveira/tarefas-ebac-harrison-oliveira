public class Custumer {
    private String gradeRequest;
    private boolean hasCompanyContract;

    public Custumer(String gradeRequest, boolean hasCompanyContract) {
        this.gradeRequest = gradeRequest;
        this.hasCompanyContract = hasCompanyContract;
    }

    public String getGradeRequest(){
        return gradeRequest;
    }

    public boolean hasCompanyContract(){
        return hasCompanyContract;
    }
}
