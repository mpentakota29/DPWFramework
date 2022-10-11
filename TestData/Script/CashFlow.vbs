Set WshShell = WScript.CreateObject("WScript.Shell")
WshShell.SendKeys WshShell.CurrentDirectory & "\TestData\IMG\CashFlow.png"
WshShell.SendKeys "{ENTER}"