LICENSE = "CLOSED"
BB_STRICT_CHECKSUM = "0"

inherit cmake setuptools3

SRC_URI = "git://github.com/google-coral/pycoral.git;branch=master;name=pycoral;protocol=https"

SRCREV_pycoral = "9972f8ec6dbb8b2f46321e8c0d2513e0b6b152ce"

S = "${WORKDIR}/git"
