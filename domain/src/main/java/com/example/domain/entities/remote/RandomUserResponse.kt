package com.example.domain.entities.remote

import java.text.SimpleDateFormat
import java.util.Date

data class RandomUserResponse(
    val info: Info,
    val results: List<Result>
)


data class Result(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)

data class Name(
    val first: String,
    val last: String,
    val title: String
)

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)

data class Street(
    val name: String,
    val number: Int
) {
    fun getStreet() = "${this.number} ${this.name}"
}

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Timezone(
    val description: String,
    val offset: String
)

data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

data class Dob(
    val age: Int,
    val date: String
) {
    private fun getDateFormant(): Date {
        date.let {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            return sdf.parse(it)
        }
    }

    fun date(): String {
        date.let {
            return SimpleDateFormat("dd/MM/yyyy").format(getDateFormant())
        }
    }
}

data class Registered(
    val age: Int,
    val date: String
)

data class Id(
    val name: String,
    val value: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)