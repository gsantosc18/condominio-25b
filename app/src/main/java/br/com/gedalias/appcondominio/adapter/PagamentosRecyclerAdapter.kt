package br.com.gedalias.appcondominio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gedalias.appcondominio.R
import br.com.gedalias.appcondominio.dto.InfoPagamentosDTO

class PagamentosRecyclerAdapter(
    private var infosPagamentos: List<InfoPagamentosDTO>,
    private val context: Context
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_pagamentos_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val infoPagamento = infosPagamentos[position]
        val view = holder as ViewHolder
        view.bindView(infoPagamento)
    }

    override fun getItemCount(): Int =  infosPagamentos.size

    fun addPagamentos(pagamentosDTO: InfoPagamentosDTO) {
        infosPagamentos += pagamentosDTO
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var apartamento = view.findViewById<TextView>(R.id.apartamento)
    var lbIsPago = view.findViewById<TextView>(R.id.lbIsPago)
    fun bindView(infoPagamentosDTO: InfoPagamentosDTO) {
        apartamento.text = infoPagamentosDTO.apartamento
        lbIsPago.text = if (infoPagamentosDTO.pago == true) "Pago" else "Pendente"
    }
}