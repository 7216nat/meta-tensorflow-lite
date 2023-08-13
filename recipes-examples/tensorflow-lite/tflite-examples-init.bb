DESCRIPTION = "Initialize the tflite apps as a service"
LICENSE = "CLOSED"

DEPENDS = "systemd"
SRC_URI = "file://tflite-examples-init.py \
            file://tflite-examples.service \
             "

do_configure[noexec] = "1"
do_compile[noexec] = "1"
inherit systemd
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "tflite-examples.service"

do_install() {
    install -d ${D}/${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tflite-examples.service ${D}/${systemd_system_unitdir}

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/tflite-examples-init.py  ${D}${sbindir}
}

RDEPENDS:${PN} = "python3"

FILES:${PN} += " ${systemd_system_unitdir}/*"
