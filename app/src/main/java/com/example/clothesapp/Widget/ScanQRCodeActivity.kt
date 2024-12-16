

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesapp.R
import com.google.zxing.integration.android.IntentIntegrator




class ScanQRCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_qr)


        val integrator = IntentIntegrator(this)
        integrator.initiateScan()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                // Пользователь отменил сканирование
            } else {
                // QR код успешно отсканирован, обработайте результат
                val scannedData = result.contents
                // Например, отобразите результат
                // Log.d("QR Result", scannedData)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}