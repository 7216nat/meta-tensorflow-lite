DESCRIPTION = "Initialize the Kuksa VSS data to some constant values"
LICENSE = "CLOSED"

SRC_URI = "file://tflite_examples_init.py \
            file://tflite_examples.service \
             "

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -D -m 0644 ${WORKDIR}/tflite_examples.service ${D}${systemd_user_unitdir}/tflite_examples.service
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../tflite_examples.service ${D}${systemd_user_unitdir}/agl-session.target.wants/tflite_examples.service

    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/tflite_examples_init.py ${D}${sbindir}
}

RDEPENDS:${PN} = "python3"
