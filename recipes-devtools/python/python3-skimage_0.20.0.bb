LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=bc1620e3f8df91caa0443f0fcc1db9b6"

PYPI_PACKAGE = "scikit_image"

SRC_URI[sha256sum] = "2cd784fce18bd31d71ade62c6221440199ead03acf7544086261ee032264cf61"

inherit pypi

FILES:${PN} += "${libdir}/python3.10/site-packages/skimage"

DIRFILES = "1"

do_install() {
    install -m 755 -d ${D}${libdir}/python3.10/site-packages/
    cp -r ${S}/skimage ${D}${libdir}/python3.10/site-packages/skimage
}

