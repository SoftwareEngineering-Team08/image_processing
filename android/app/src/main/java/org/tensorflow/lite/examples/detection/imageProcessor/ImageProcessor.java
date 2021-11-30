package org.tensorflow.lite.examples.detection.imageProcessor;

import android.app.Application;

public class ImageProcessor extends Application {
    private boolean isBack;
    private boolean isRight;

    public boolean getIsBack(){
        return isBack;
    }
    public void setIsBack(boolean givenBool){
        this.isBack = givenBool;
    }

    public boolean getIsRight(){
        return isRight;
    }
    public void setIsRight(boolean givenBool){
        this.isRight = givenBool;
    }
}
