LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=cafac3cc441f125243949fd079a11bbb"

PYPI_PACKAGE = "lap"

DEPENDS = "${PYTHON_PN}-numpy-native ${PYTHON_PN}-numpy ${PYTHON_PN}-joblib"

RDEPENDS_${PN} += "${PYTHON_PN}-numpy"

SRC_URI[sha256sum] = "c4dad9976f0e9f276d8a676a6d03632c3cb7ab7c80142e3b27303d49f0ed0e3b"

inherit pypi
inherit setuptools3
inherit pkgconfig