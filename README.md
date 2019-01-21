# bspatch
android使用bsdiff和bspatch进行增量更新
我将bsdiff和bspach的C语言代码打包成动态库供主项目调用
具体使用方法
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
    
    通过调用jni方法，第一个方法是生成增量更新的文件，第二个方法是把增量更新的文件和旧的APK合并成新apk，然后就可以本地安装了。
    增量更新的原理就是本地生成旧版升级到新版的差分包文件，然后APP通过下载差分包文件和手机上已安装的旧版apk合并，再还原成新版apk并安装，
    从而达到节省流量的目的。
    我同时上传了可以在windows上执行的bsdiff和bspatch的可执行文件，可通过命令行执行生成差分包，这样比在android上面操作方便一点，android只需要
    下载并合成差分包就可以
