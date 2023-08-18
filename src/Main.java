public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};
        array = sortArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] sortArray(int[] arr) {
        //данный метод не идеален,может возникнуть StackOverflowError,но для обучения он мне показался неплохим
        if (arr == null) {
            System.out.println("массив пуст");
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - (arr.length / 2)];
        System.arraycopy(arr, 0, left, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, right, 0, arr.length - (arr.length / 2));
        return mergeArray(sortArray(left), sortArray(right));
    }

    public static int[] mergeArray(int[] left, int[] right) {
        int[] resultOFMerge = new int[left.length + right.length];
        int l = left.length;
        int r = right.length;
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                resultOFMerge[k] = left[i];
                i++;
            } else {
                resultOFMerge[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            resultOFMerge[k] = left[i];
            i++;
            k++;
        }
        while (j < r) {
            resultOFMerge[k] = right[j];
            j++;
            k++;
        }
        return resultOFMerge;
    }
}
