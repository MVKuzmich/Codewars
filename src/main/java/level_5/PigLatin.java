package level_5;

public class PigLatin {

    public String pigIt(String str) {
        return str.replaceAll("([A-z])([A-z]*)", "$2".concat("$1").concat("ay"));
    }
}
