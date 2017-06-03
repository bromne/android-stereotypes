package com.bromne.stereotypes.data

import com.google.common.collect.ImmutableSet

fun <T> ImmutableSet<T>.toBuilder() = ImmutableSet.builder<T>().addAll(this)

