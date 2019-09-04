package com.robelseyoum3.startwarsretrofitobserver.models

import com.google.gson.annotations.SerializedName

data class MovieSource (

	@SerializedName("count") val count : Int,
	@SerializedName("next") val next : String,
	@SerializedName("previous") val previous : String,
	@SerializedName("results") val results : List<Results>
)