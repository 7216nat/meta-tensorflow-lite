#!/usr/bin/env python3

import json
import kuksa_viss_client
import time
import subprocess
import os
import signal
import seeed_python_reterminal.core as rt
import seeed_python_reterminal.button as rt_btn

def kill_process(process):
    print("killing process")
    if process:
        print(process.pid)
        os.killpg(os.getpgid(process.pid), signal.SIGTERM)
        print("process killed")
    else:
        print("process not found")

def main():
    
    device = rt.get_button_device()
    process = None
    while True:
        for event in device.read_loop():
            buttonEvent = rt_btn.ButtonEvent(event)
            if buttonEvent.name != None:
                print(f"name={str(buttonEvent.name)} value={buttonEvent.value}")
                name = str(buttonEvent.name)
                value = buttonEvent.value
                if name == "ButtonName.F1" and value == 0:
                    kill_process(process)
                    process = subprocess.Popen("python3 kws.py >>./log.log 2>&1", shell=True, cwd="/usr/share/tensorflow/lite/examples/python/ADAS-apps/code/", preexec_fn=os.setsid)
                    print("process created: " + str(process.pid))
                elif name == "ButtonName.F2" and value == 0:
                    kill_process(process)
                    process = subprocess.Popen("python3 detect.py >>./log.log 2>&1", shell=True, cwd="/usr/share/tensorflow/lite/examples/python/ADAS-apps/code/", preexec_fn=os.setsid)
                    print("process created: " + str(process.pid))
                elif name == "ButtonName.F3" and value == 0:
                    kill_process(process)
                    process = subprocess.Popen("python3 detect.py --do_recognize >>./log.log 2>&1", shell=True, cwd="/usr/share/tensorflow/lite/examples/python/ADAS-apps/code/", preexec_fn=os.setsid)
                    print("process created: " + str(process.pid))
                elif name == "ButtonName.O" and value == 0:
                    kill_process(process)

if __name__ == "__main__":
    main()
