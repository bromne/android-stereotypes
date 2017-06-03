package com.bromne.stereotypes.data

/**
 * exclude nullable value from Iterable<T?> and generate new Iterable<T> that the type is not
 * nullable.
 */
@Suppress("unused")
fun <T> Iterable<T?>.excludeNullable(): Iterable<T> {
    return this.filter { it != null }
            .map { it!! }
}
