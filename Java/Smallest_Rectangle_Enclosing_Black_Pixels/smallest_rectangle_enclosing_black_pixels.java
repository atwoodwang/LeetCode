//An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

//For example, given the following image:

//[
//  "0010",
//  "0110",
//  "0100"
//]
//and x = 0, y = 2,
//Return 6.


public class Solution {
    private char[][] image;
    public int minArea(char[][] iImage, int x, int y) {
        image = iImage;
        int m = image.length, n = image[0].length;
        int top = search(0, x, 0, n, true, true);
        int bottom = search(x , m, 0, n, false, true);
        int left = search(0, y, top, bottom, true, false);
        int right = search(y , n, top, bottom, false, false);
        return (right - left) * (bottom - top);
    }
    private boolean isWhite(int mid, int k, boolean isRow) {
        return ((isRow) ? image[mid][k] : image[k][mid]) == '0';
    }
    private int search(int i, int j, int low, int high, boolean opt, boolean isRow) {
        while (i != j) {
            int k = low, mid = (i + j) / 2;
            while (k < high && isWhite(mid, k, isRow)) ++k;
            if (k < high == opt)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}