LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=0b7500b676ce0b3f073501cb1fab205c"

PYPI_PACKAGE = "PyGObject"

SRC_URI[sha256sum] = "21524cef33100c8fd59dc135948b703d79d303e368ce71fa60521cc971cd8aa7"


DEPENDS = " \
    glib-2.0 \
    gobject-introspection \
    python3-pycairo \
"
RDEPENDS:${PN} += " \
    glib-2.0 \
    gobject-introspection \
    python3-pycairo \
"
#   

inherit pkgconfig pypi setuptools3