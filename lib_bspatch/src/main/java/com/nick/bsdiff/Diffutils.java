package com.nick.bsdiff;

/**
 * Created by nick on 2017/2/27.
 */

public class Diffutils {

    static {

        try {
            System.loadLibrary("native-lib");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }


    /**
     * @param oldPath   旧的安装包路径
     * @param newPath   新的安装包路径
     * @param patchPath 差分包路径
     * @return 生成的结果
     */
    public static native int generateDiffApk(String oldPath, String newPath, String patchPath);

    /**
     * @param oldPath   旧的安装包路径
     * @param newPath   新的安装包路径
     * @param patchPath 差分包路径
     * @return 生成的结果
     */
    public static native int mergeDiffApk(String oldPath, String newPath, String patchPath);
}
