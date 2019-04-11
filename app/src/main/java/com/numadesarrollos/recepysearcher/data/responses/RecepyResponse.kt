package com.numadesarrollos.recepysearcher.data.responses

import com.numadesarrollos.recepysearcher.data.Recepy

data class RecepyResponse (val title:String, val version:String, val href:String,val results: List<Recepy>)