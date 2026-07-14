class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int clr, int old){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != clr) return;

        if(image[i][j] == old) return;

        image[i][j] = old;

        dfs(image, i - 1, j, clr, old);
        dfs(image, i, j + 1, clr, old);
        dfs(image, i + 1, j, clr, old);
        dfs(image, i, j - 1, clr, old);
    }
}