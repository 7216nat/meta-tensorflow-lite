require recipes-framework/coral/libedgetpu-common.inc

RCONFLICTS:${PN} = " libedgetpu-std"

EXTRA_OEMAKE = " libedgetpu"

do_install:prepend() {
    install -d ${D}/${libdir}
    install -m 0755 ${S}/out/direct/k8/libedgetpu.so.1 ${D}/${libdir}
    install -m 0755 ${S}/out/direct/k8/libedgetpu.so.1.0 ${D}/${libdir}
    
    install -d ${D}/etc/udev/rules.d/
    install -m 644 ${S}/debian/edgetpu-accelerator.rules ${D}/etc/udev/rules.d/99-edgetpu-accelerator.rules

    install -d ${D}/${includedir}
    install -m 755 ${S}/tflite/public/edgetpu.h ${D}/${includedir}/edgetpu.h
    install -m 755 ${S}/tflite/public/edgetpu_c.h ${D}/${includedir}/edgetpu_c.h
}

FILES_${PN} += "${libdir}/libedgetpu.so.1 \
                ${libdir}/libedgetpu.so.1.0 \
"
