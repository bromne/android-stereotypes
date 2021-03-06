package com.bromne.stereotypes.data

import java.io.Serializable

sealed class Either<L, R> : Serializable {
    val isLeft: Boolean get() {
        return when (this) {
            is Left -> true
            is Right -> false
        }
    }

    val isRight: Boolean get() = !this.isLeft

    fun <T> map(leftMapper: (L) -> T, rightMapper: (R) -> T): T {
        return when (this) {
            is Left -> leftMapper(this.value)
            is Right -> rightMapper(this.value)
        }
    }

    companion object {
        fun <L, R> left(value: L): Either<L, R> = Left(value)
        fun <L, R> right(value: R): Either<L, R> = Right(value)
    }

    class Left<L, R>(val value: L) : Either<L, R>() {
        override fun equals(other: Any?): Boolean {
            if (this === other)
                return true
            else
                return (other is Left<*, *> ) && (value == other.value)
        }

        override fun hashCode(): Int {
            return value?.hashCode() ?: 0
        }
    }

    class Right<L, R>(val value: R) : Either<L, R>() {
        override fun equals(other: Any?): Boolean {
            if (this === other)
                return true
            else
                return (other is Right<*, *> ) && (value == other.value)
        }

        override fun hashCode(): Int {
            return value?.hashCode() ?: 0
        }
    }
}
