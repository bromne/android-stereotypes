package com.bromne.stereotypes.io

import android.content.SharedPreferences
import android.util.Base64
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable

@Suppress("unused")
fun SharedPreferences.Editor.putSerializable(key: String, data: Serializable): SharedPreferences.Editor {
    val baos = ByteArrayOutputStream()
    val oos = ObjectOutputStream(baos)
    val bytes = oos.use {
        it.writeObject(data)
        baos.toByteArray()
    }
    val encoded = Base64.encodeToString(bytes, Base64.DEFAULT)
    this.putString(key, encoded)
    return this
}

@Suppress("unused", "UNCHECKED_CAST")
fun <T> SharedPreferences.getSerializable(key: String): T? where T : Serializable {
    val base64 = this.getString(key, null)
    if (base64 != null) {
        val bytes = Base64.decode(base64, Base64.DEFAULT)
        val bais = ByteArrayInputStream(bytes)
        val ois = ObjectInputStream(bais)

        val value = ois.readObject()

        return value as T
    } else {
        return null
    }
}

@Suppress("unused")
fun SharedPreferences.update(editting: (SharedPreferences.Editor) -> SharedPreferences.Editor): Unit {
    editting(this.edit())
            .commit()
}
