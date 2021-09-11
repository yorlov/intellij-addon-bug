package com.stiltsoft.intellij.toolchain

import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement

inline fun <reified T : PsiElement> psiElement(): PsiElementPattern.Capture<T> = PlatformPatterns.psiElement(T::class.java)