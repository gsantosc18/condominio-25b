package br.com.gedalias.appcondominio.service

import android.util.Log
import br.com.gedalias.appcondominio.dto.InfoPagamentosDTO
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PagamentosService {
    private val db: FirebaseFirestore = Firebase.firestore

    fun all(actionPagamentos: ActionPagamentos) {
        db.collection("pagamentos")
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    Log.i("Dados 1", task.result.toString())
                    val results = task.result.toObjects(InfoPagamentosDTO::class.java)
                    actionPagamentos.onReceive(results)
                }
            }
    }
}

interface ActionPagamentos {
    fun onReceive(pagamentos: List<InfoPagamentosDTO>)
}