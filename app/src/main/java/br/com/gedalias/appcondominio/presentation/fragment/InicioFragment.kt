package br.com.gedalias.appcondominio.presentation.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gedalias.appcondominio.R

class InicioFragment: Fragment() {
    private val chavePix = "91992930667"
    private var btnCopyPix: ImageButton? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_inicio, container, false)
        val context = inflater.context

        btnCopyPix = root.findViewById(R.id.btnCopyPix)
        btnCopyPix!!.setOnClickListener(actionOnClickCopyPix(context))

        return root
    }

    private fun actionOnClickCopyPix(context: Context): View.OnClickListener = View.OnClickListener {
        var clipBoard: ClipboardManager = context.getSystemService(AppCompatActivity.CLIPBOARD_SERVICE) as ClipboardManager
        var clip = ClipData.newPlainText("chave pix condominio", chavePix)
        clipBoard.setPrimaryClip(clip)
        Toast.makeText(context, "Chave copiada!", Toast.LENGTH_SHORT).show()
    }
}