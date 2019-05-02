# Copyright (C) 2014 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "SDK Cross compiler wrappers for LLVM based C/C++ compiler"
HOMEPAGE = "http://clang.llvm.org/"
LICENSE = "NCSA"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/NCSA;md5=1b5fdec70ee13ad8a91667f16c1959d7"
SECTION = "devel"

PN = "clang-crosssdk-${TARGET_ARCH}"

require clang.inc
inherit crosssdk
DEPENDS += "clang-native nativesdk-clang-glue virtual/${TARGET_PREFIX}binutils-crosssdk virtual/nativesdk-${TARGET_PREFIX}libc-for-gcc"

S = "${WORKDIR}"

do_install() {
        install -d  ${D}${bindir}
        ln -sf ../clang ${D}${bindir}/${TARGET_PREFIX}clang
        ln -sf ../clang++ ${D}${bindir}/${TARGET_PREFIX}clang++
}

sysroot_stage_all () {
        sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}

SSTATE_SCAN_FILES += "*-clang *-clang++"
PACKAGES = ""
