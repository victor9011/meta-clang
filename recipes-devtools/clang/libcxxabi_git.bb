#
# This file was mstnet-pkg-mst-base compile shell
#

DESCRIPTION = "MST Base Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "\
             file://libc++abi.so \
             file://libc++abi.a \
             file://cxxabi.h \
             file://__cxxabi_config.h \
"

DEPENDS = "libcxx"

do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/libc++abi.a ${D}${libdir}/libc++abi.a
    install -m 0755 ${WORKDIR}/libc++abi.so ${D}${libdir}/libc++abi.so.1.0
    cd ${D}${libdir}/
    ln -s libc++abi.so.1.0 libc++abi.so.1
    ln -s libc++abi.so.1.0 libc++abi.so
    install -d ${D}${includedir}/c++/v1
    cp ${WORKDIR}/cxxabi.h ${D}${includedir}/c++/v1
    cp ${WORKDIR}/__cxxabi_config.h ${D}${includedir}/c++/v1
}
