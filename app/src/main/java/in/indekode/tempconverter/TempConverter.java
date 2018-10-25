package in.indekode.tempconverter;

public class TempConverter {

    String unit1;
    String unit2;
    String value1;
    String result;

    public TempConverter() {
    }

    public TempConverter(String unit1, String unit2, String value1, String result) {
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.value1 = value1;
        this.result = result;
    }


    public String getUnit1() {
        return unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public String getValue1() {
        return value1;
    }

    public String getResult() {
        return result;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
