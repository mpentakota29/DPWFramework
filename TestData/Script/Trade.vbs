Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.SendKeys WshShell.CurrentDirectory & "\TestData\IMG\Trade.png"
WshShell.SendKeys "{ENTER}"