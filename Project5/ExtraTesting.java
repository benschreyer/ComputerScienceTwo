//Ben Schreyer 11/20/2020
//Testing file for methods, less formal
public class ExtraTesting
{
    public static void main(String[] args) throws InvalidMorseCodeException {
        MorseCodeTree extraTest = new MorseCodeTree();
        extraTest.buildTree();
        extraTest.addNode(extraTest.getRoot(),"---.","HELLO");
        System.out.println(extraTest.fetch("---"));
        System.out.println(extraTest.toArrayList());
        System.out.println(MorseCodeConverter.convertToEnglish("....... --- .-- / -.. --- / .. / .-.. --- ...- . / - .... . . / .-.. . - / -- . / -.-. --- ..- -. - / - .... . / .-- .- -.-- ..."));
        System.out.println(MorseCodeConverter.convertToEnglish(""));
    }
}
