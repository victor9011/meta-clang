#
# This file was mstnet-pkg-mst-base compile shell
#

DESCRIPTION = "MST Base Library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "\
             file://libc++.so \
             file://libc++.a \
             file://v1 \
"


do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/libc++.a ${D}${libdir}/libc++.a
    install -m 0755 ${WORKDIR}/libc++.so ${D}${libdir}/libc++.so.1.0
    cd ${D}${libdir}/
    ln -s libc++.so.1.0 libc++.so.1
    ln -s libc++.so.1.0 libc++.so
    install -d ${D}/${includedir}/c++
    cp ${WORKDIR}/v1 ${D}/${includedir}/c++ -rf
}
INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN} += "staticdev"
INSANE_SKIP_${PN} += "dev-elf"
