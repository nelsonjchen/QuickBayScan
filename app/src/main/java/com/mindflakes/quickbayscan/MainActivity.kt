package com.mindflakes.quickbayscan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.mindflakes.quickbayscan.ui.theme.QuickBayScanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       Scan()


    }

    fun Scan() {
        val options = GmsBarcodeScannerOptions.Builder()
            .allowManualInput()
            .setBarcodeFormats(
//                Barcode.FORMAT_CODABAR,
                Barcode.FORMAT_CODE_39,
                Barcode.FORMAT_CODE_93,
                Barcode.FORMAT_CODE_128,
                Barcode.FORMAT_EAN_8,
                Barcode.FORMAT_EAN_13,
//                Barcode.FORMAT_ITF,
                Barcode.FORMAT_UPC_A,
                Barcode.FORMAT_UPC_E
            )
            .enableAutoZoom() // available on 16.1.0 and higher
            .build()
        val scanner = GmsBarcodeScanning.getClient(this, options)
        scanner.startScan()
            .addOnSuccessListener { barcode ->
                val rawValue: String? = barcode.rawValue
                if (rawValue != null) {
                    // Base URL Example
                    // https://www.ebay.com/sch/i.html?_from=R40&_nkw=9780345453747&_sacat=0&rt=nc&LH_Sold=1&LH_Complete=1
                    // Instead of 9780345453747, we want to use the rawValue, if it's set, otherwise try scanning again
                    // Open the URL in the browser
                    // Close the app
                    val url = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=$rawValue&_sacat=0&rt=nc&LH_Sold=1&LH_Complete=1"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    finish()
                }

            }
            .addOnCanceledListener {
                Scan()
            }
            .addOnFailureListener { e ->
                Scan()
            }
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuickBayScanTheme {
        Greeting("Android")
    }
}