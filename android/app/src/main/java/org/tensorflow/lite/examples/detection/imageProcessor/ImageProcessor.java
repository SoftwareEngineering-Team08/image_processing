package org.tensorflow.lite.examples.detection.imageProcessor;

import android.app.Application;

public class ImageProcessor extends Application {
    private boolean isBack;
    private boolean isRight;
    private int maximum;
    private int current;
    private int limited;
    private float detectedPos;

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

    public int getMaximum(){
        return maximum;
    }
    public void setMaximum(int givenMax){
        this.maximum = givenMax;
    }

    public int getCurrent(){
        return current;
    }
    public void setCurrent(int givenCounted){
        this.current = givenCounted;
    }

    public int getLimited(){
        return limited;
    }
    public void setLimited(int givenLimited){
        this.limited = givenLimited;
    }


    public float getDetectedPos() {
        return detectedPos;
    }

    public void setDetectedPos(float detectedPos) {
        this.detectedPos = detectedPos;
    }
}
