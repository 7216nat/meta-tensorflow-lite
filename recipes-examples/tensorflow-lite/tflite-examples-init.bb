DESCRIPTION = "Initialize the Kuksa VSS data to some constant values"
LICENSE = "CLOSED"

SRC_URI = "file://tflite-examples-init.py \
            file://tflite-examples.service \
             "

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -D -m 0644 ${WORKDIR}/tflite-examples.service ${D}${systemd_user_unitdir}/tflite-examples.service
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../tflite-examples.service ${D}${systemd_user_unitdir}/agl-session.target.wants/tflite-examples.service

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/tflite-examples-init.py  ${D}${sbindir}
}

RDEPENDS:${PN} = "python3"
