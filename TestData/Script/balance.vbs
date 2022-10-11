Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.SendKeys WshShell.CurrentDirectory & "\TestData\IMG\balance.png"
WshShell.SendKeys "{ENTER}"