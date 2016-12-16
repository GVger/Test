#if !defined(AFX_MODIDLG_H__18D57180_C2BB_45AC_A354_A205F7B1CB80__INCLUDED_)
#define AFX_MODIDLG_H__18D57180_C2BB_45AC_A354_A205F7B1CB80__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// ModiDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// CModiDlg dialog

class CModiDlg : public CDialog
{
// Construction
public:
	CModiDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(CModiDlg)
	enum { IDD = IDD_MODIBOX };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CModiDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(CModiDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_MODIDLG_H__18D57180_C2BB_45AC_A354_A205F7B1CB80__INCLUDED_)
