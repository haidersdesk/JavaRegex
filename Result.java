package RegularExpressions;

public class Result {
    int lineNr;
    int startIndex;
    int endIndex;
    int numberOfAnswers;
    String inputResult;
    String inputPattern;


    public Result(String inputPattern, String inputResult, int lineNr, int startIndex, int endIndex){
        this.inputPattern = inputPattern;
        this.inputResult = inputResult;
        this.lineNr = lineNr;
        this.startIndex = startIndex;
        this.endIndex = endIndex;

    }
    public Result(String inputResult, int numberOfAnswers) {
        this.inputResult= inputResult;
        this.numberOfAnswers = numberOfAnswers;
    }

    @Override
    public String toString() {

        if (numberOfAnswers > 0) {
            return "\n" + "Result of Search: " + inputResult + ":::" + numberOfAnswers + " Results" ;

        }
        else{
            return "\n" +"Result of Search: "+inputResult+
                    "  lineNr :" + lineNr +
                    "  starting Index :" + startIndex +
                    "  ending Index :" + endIndex ;


        }
    }
}
