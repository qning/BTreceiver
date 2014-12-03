package com.example.android.BluetoothChat;

import java.util.List;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.PorterDuff.Mode;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder.Callback;

	public class MySurfaceView extends SurfaceView implements Callback {

		private static final String TAG = "MySurfaceView";

		private int width;
		private int height;

		private SurfaceHolder mHolder;

		private Camera mCamera;
		
		//private int mMultiplyColor;
		
		public MySurfaceView(Context context, AttributeSet attrs) {
		    super(context, attrs);
		    mHolder = getHolder();
		    mHolder.addCallback(this);
		   // mMultiplyColor = getResources().getColor(R.color.multiply_color);
		}

		// @Override
		// protected void onDraw(Canvas canvas) {
		// Log.w(this.getClass().getName(), "On Draw Called");
		// }
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
				
		}
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			synchronized (this) {       
		        this.setWillNotDraw(false); // This allows us to make our own draw calls to this canvas
		    }
		    
		}
	
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
		    synchronized (this) {
		        try {
		            if (mCamera != null) {
		                //mHolder.removeCallback(this);
		                mCamera.setPreviewCallback(null);
		                mCamera.stopPreview();
		                mCamera.release();
		            }
		        } catch (Exception e) {
		            Log.e("Camera", e.getMessage());
		        }
		    }
		}

	}
	
	
