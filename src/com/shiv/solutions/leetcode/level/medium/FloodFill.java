package com.shiv.solutions.leetcode.level.medium;

import com.shiv.solutions.leetcode.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shivshankar Sahoo
 *
 * @problem
 * <a href="https://leetcode.com/problems/flood-fill/description/">Leetcode</a></br>
 *
 * @description
 * An image is represented by an m x n integer grid image where image[i][j]</br>
 * represents the pixel value of the image.</br>
 * You are also given three integers sr, sc, and color. You should perform a flood fill</br>
 * on the image starting from the pixel image[sr][sc].</br>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally</br>
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected</br>
 * 4-directionally to those pixels (also with the same color), and so on. Replace the color of</br>
 * all of the aforementioned pixels with color.</br>
 * Return the modified image after performing the flood fill.</br>
 *
 */
public class FloodFill {

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    private static void dfs(int[][] image, int row, int column, int color, int newColor) {
        if (image[row][column] == color) {
            image[row][column] = newColor;
            if (row >= 1) dfs(image, row-1, column, color, newColor);
            if (column >= 1) dfs(image, row, column-1, color, newColor);
            if (row+1 < image.length) dfs(image, row+1, column, color, newColor);
            if (column+1 < image[0].length) dfs(image, row, column+1, color, newColor);
        }
    }

    public static void main(String[] args) {
        final List<int[][]> imageArrayList = new ArrayList() {{
            add(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
            add(new int[][] {{0, 0, 0}, {0, 0, 0}});
            add(new int[][] {{0, 0, 0}, {1, 1, 1}});
            add(new int[][] {{1, 0, 0},{1, 1, 0},{1, 0, 1}});
        }};
        final int[] sourceRow = new int[] {1, 0, 0, 1};
        final int[] sourceColumn = new int[] {1, 0, 0, 2};
        final int[] newColor = new int[] {2, 0, 3, 3};
        for(int i=0; i<imageArrayList.size(); i++) {
            System.out.println("Input image array:");
            for(int[] arr : imageArrayList.get(i)) {
                System.out.print(Arrays.toString(arr) + Constants.ONE_SPACE);
            }
            System.out.println(Constants.NEW_LINE + "New color: " + newColor[i]);
            int[][] result = floodFill(imageArrayList.get(i), sourceRow[i], sourceColumn[i], newColor[i]);
            System.out.println("Image array after flood fill:");
            for(int[] arr : result) {
                System.out.print(Arrays.toString(arr) + Constants.ONE_SPACE);
            }
            System.out.println(Constants.NEW_LINE);
        }
    }

}
