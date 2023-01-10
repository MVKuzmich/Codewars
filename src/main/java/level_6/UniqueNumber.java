package level_6;


public class UniqueNumber {
    public double findUniq(double arr[]) {
        double unique = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (unique == arr[i] && arr[i] != arr[i + 1]) {
                return arr[i + 1];
            } else if (unique != arr[i] && arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return unique;
    }
}
