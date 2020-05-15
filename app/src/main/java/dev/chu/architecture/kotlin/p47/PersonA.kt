package dev.chu.architecture.kotlin.p47

import javax.inject.Inject

class PersonA @Inject constructor(val name: String, val age: Int)   // 생성자 주입